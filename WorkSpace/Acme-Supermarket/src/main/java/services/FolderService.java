package services;

import java.util.ArrayList;
import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Actor;
import domain.Folder;
import domain.Message;

import repositories.FolderRepository;

@Service
@Transactional 
public class FolderService {
 	//Managed repository -----------------------------------------------------
	
	@Autowired
	private FolderRepository folderRepository;
	
	//Supporting services ----------------------------------------------------
	
	@Autowired
	private ActorService actorService;
	
	//Constructors -----------------------------------------------------------
	
	public FolderService(){
		super();
	}
	
	//Simple CRUD methods ----------------------------------------------------

	/** 
	 * Devuelve Folder preparado para ser modificado. Necesita usar save para que persista en la base de datos
	 */	
	//req: 24.2
	public Folder create(){
		Folder result;
		
		result = new Folder();
		
		return result;
	}
	
	/**
	 * Guarda un folder creado o modificado
	 */
	//req: 24.2
	public void save(Folder folder){
		Assert.notNull(folder);
		
		folderRepository.save(folder);
	}
	
	/**
	 * Elimina un folder. No elimina carpetas del sistema
	 */
	//req: 24.2	
	public void delete(Folder folder){
		Assert.notNull(folder);
		Assert.isTrue(folder.getId() != 0);
		
		// Si es del sistema no debe poder borrarse
		Assert.isTrue(!folder.getIsSystem(), "It's a system Folder and couldn't be removed");
		
		folderRepository.delete(folder);
	}
	
	//Other business methods -------------------------------------------------
	
	/**
	 * A�ade un mensaje a una carpeta dada
	 */
	public void addMessage(Folder f, Message m){
		Assert.notNull(f);
		Assert.notNull(m);
		
		f.addMessage(m);
		this.save(f);
	}
	
	/**
	 * Borrar un mensaje de una carpeta dada
	 */
	public void removeMessage(Folder f, Message m){
		Assert.notNull(m);
		Assert.notNull(f);
		if (f.getName().equals("TrashBox") && f.getIsSystem()){
			f.removeMessage(m);
			this.save(f);
		}
		else{
			Actor actor = actorService.findByPrincipal();
			int count;
			
			count = 0;
			Folder trashBox;
			
			trashBox = null;
			
			for(Folder folder:actor.getFolders()){
				if(folder.getMessages().contains(m)){
					count++;
				}
				if(folder.getName().equals("TrashBox") && folder.getIsSystem()){
					trashBox = folder;
				}
			}
			f.removeMessage(m);
			if(count == 1){
				trashBox.addMessage(m);
				this.save(trashBox);
			}
			this.save(f);
		}
	}
	
	/**
	 * Devuelve todas las carpetas del actor actual
	 */
	//req: 24.1
	public Collection<Folder> findAllByActor(){
		Collection<Folder> result;
		Actor actor;
		
		actor = actorService.findByPrincipal();
		result = folderRepository.findAllByActorId(actor.getId());
		
		return result;
	}

	/**
	 * Crea y guarda las carpetas por defecto
	 */
	//req: x
	public Collection<Folder> initializeSystemFolder(Actor actor){
		Collection<Folder> result;
		Collection<String> names;
		
		result = new ArrayList<Folder>();
		names = new ArrayList<String>();
		
		names.add("Inbox");
		names.add("Outbox");
		names.add("Trashbox");
				
		
		for (String string : names) {
			Folder temp;
			
			temp = this.create();
			
			temp.setIsSystem(true);
			temp.setName(string);
			temp.setActor(actor);
						
			result.add(temp);
		}
		
		actor.setFolders(result);
		
		return result;
	}
}

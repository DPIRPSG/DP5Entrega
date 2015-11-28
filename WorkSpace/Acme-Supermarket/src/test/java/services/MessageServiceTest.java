package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import domain.Actor;
import domain.Consumer;
import domain.Folder;
import domain.Message;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml",
	"classpath:spring/config/packages.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)

public class MessageServiceTest extends AbstractTest {

	// Service under test -------------------------
	@Autowired
	private FolderService folderService;
	@Autowired
	private ConsumerService consumerService;
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ActorService actorService;
		
	// Test ---------------------------------------
	@Test
	public void testManageFoldersAndMessages1(){
		System.out.println("Requisito 24.2 - Manage his or her folders and messages.");
		System.out.println("MessageServiceTest - testManageFoldersAndMessages1 - StartPoint");
		
		Message message;
		Collection<Folder> folders;
		Collection<Message> messages;
		Collection<Actor> recipients;
		Consumer consumer;
		Date moment;
		
		authenticate("consumer1");
		consumer = consumerService.findAll().iterator().next();
		message = messageService.create();
		messages = new ArrayList<Message>();
		recipients = new ArrayList<Actor>();
		moment = new Date();
		
		System.out.println("Consumer sobre el que se trabaja");
		System.out.println(consumer.getName());
		folders = consumer.getFolders();
		recipients.add(consumer);
		
		System.out.println("Lista de folders del consumer");
		for(Folder f:folders){
			messages.addAll(f.getMessages());
			System.out.println(f.getName());
		}
		System.out.println("Lista de mensajes del consumer antes de añadir uno nuevo");
		for(Message m : messages) {
			System.out.println(m.getSubject() + ": " + m.getBody());
		}
		
		message.setSubject("Prueba");
		message.setBody("Probamos a crear un mensaje");
		message.setMoment(moment);
		message.setSender(consumer);
		message.setRecipients(recipients);
		
		messageService.firstSave(message);
		
		//messageService.addMessageToFolders(message);
		
		Actor actor;
		
		actor = actorService.findByPrincipal();
		System.out.println("Mensajes enviados: ");
		for (Folder f : actor.getFolders()) {
			System.out.println("Folder: "+f.getName());
			for (Message m : f.getMessages()) {
				System.out.println(m.getSubject() + ": " + m.getBody());
			}
		}
		System.out.println();
		
		authenticate(null);
		
		System.out.println("MessageServiceTest - testManageFoldersAndMessages1 - FinishPoint");
	}
	
	@Test
	public void testManageFoldersAndMessages2(){
		System.out.println("Requisito 24.2 - Manage his or her folders and messages.");
		System.out.println("MessageServiceTest - testManageFoldersAndMessages1 - StartPoint");
		
		Message message;
		Collection<Folder> folders;
		Collection<Message> messages;
		Collection<Actor> recipients;
		Consumer consumer;
		Date moment;
		Folder folderToEliminate;
		
		authenticate("consumer1");
		consumer = consumerService.findAll().iterator().next();
		//message = consumer.getFolders().iterator().next().getMessages().iterator().next();
		messages = new ArrayList<Message>();
		recipients = new ArrayList<Actor>();
		moment = new Date();
		message = null;
		folderToEliminate = null;
		
		System.out.println("Consumer sobre el que se trabaja");
		System.out.println(consumer.getName());
		folders = consumer.getFolders();
		recipients.add(consumer);
		
		System.out.println("Lista de folders del consumer");
		for(Folder f:folders){
			messages.addAll(f.getMessages());
			//System.out.println(f.getName());
			for(Message m:f.getMessages()){
				System.out.println(f.getName() + " -> " + m.getSubject());
				message = m;
				folderToEliminate = f;
				
			}
		}
		
		//message.setSubject("Prueba");
		//message.setBody("Probamos a crear un mensaje");
		//message.setMoment(moment);
		//message.setSender(consumer);
		//message.setRecipients(recipients);
		
		//messageService.firstSave(message);
		
		//messageService.addMessageToFolders(message);
		System.out.println("Antes de eliminar");
		messageService.deleteMessageFromFolder(message, folderToEliminate);
		System.out.println("Después de eliminar");
		
		Actor actor;
		
		actor = actorService.findByPrincipal();
		
		System.out.println("Lista de folders del consumer");
		for(Folder f:actor.getFolders()){
			for(Message m:f.getMessages()){
				System.out.println(f.getName() + " -> " + m.getSubject());
				message = m;
				folderToEliminate = f;
				
			}
		}
		System.out.println();
		
		authenticate(null);
		
		System.out.println("MessageServiceTest - testManageFoldersAndMessages1 - FinishPoint");
	}
	
	@Test
	public void testManageFoldersAndMessages3(){
		System.out.println("Requisito 24.2 - Manage his or her folders and messages.");
		System.out.println("FolderServiceTest - testManageFoldersAndMessages3 - StartPoint");
		
		Folder folder;
		Collection<Folder> folders;
		Collection<Message> messages;
		Consumer consumer;
		
		authenticate("consumer1");
		consumer = consumerService.findAll().iterator().next();
		folder = folderService.create();
		messages = new ArrayList<Message>();
		
		System.out.println("Consumer sobre el que se trabaja");
		System.out.println(consumer.getName());
		folders = consumer.getFolders();
		
		System.out.println("Lista de folders del consumer antes de añadir uno nuevo");
		for(Folder f:folders){
			System.out.println(f.getName());
		}
		folder.setName("Folder nueva");
		folder.setIsSystem(false);
		folder.setActor(consumer);
		folder.setMessages(messages);
		
		folders.add(folder);
		
		System.out.println("Lista de folders del consumer después de añadir una nueva");
		consumer.setFolders(folders);
		folders = consumer.getFolders();
		for(Folder f:folders){
			System.out.println(f.getName());
		}
		
		for(Folder f:folders){
			if(f.getIsSystem()==false){
				f.setName("Folder actualizada");
				break;
			}
		}
		
		consumer.setFolders(folders);
		folders = consumer.getFolders();
		
		System.out.println("Lista de folders del consumer tras la modificación de una que no es del sistema.");
		for(Folder f:folders){
			System.out.println(f.getName());
		}
		
		authenticate(null);
		
		System.out.println("FolderServiceTest - testManageFoldersAndMessages3 - FinishPoint");
	}
	
	@Test
	public void testManageFoldersAndMessages4(){
		System.out.println("Requisito 24.2 - Manage his or her folders and messages.");
		System.out.println("FolderServiceTest - testManageFoldersAndMessages4 - StartPoint");
		
		Message message;
		Consumer consumer;
		Collection<Message> received;
		Folder folder;
		
		authenticate("consumer1");
		message = null;
		folder = null;
		consumer = consumerService.findAll().iterator().next();
		received = new ArrayList<Message>();
		received = consumer.getReceived();
		
		System.out.println("Mensajes antes:");
		for(Message m:received){
			System.out.println(m.getSubject() + ": " + m.getBody());
			message = m;
		}
		
		for(Folder f:consumer.getFolders()){
			if(f.getMessages().contains(message)){
				folder = f;
			}
		}
		
		//messageService.deleteMessageFromFolder(message, folder);
		
		
		System.out.println("Mensajes después:");
		received = consumer.getReceived();
		for(Message m:received){
			System.out.println(m.getSubject() + ": " + m.getBody());
		}
		
		authenticate(null);
		
		System.out.println("FolderServiceTest - testManageFoldersAndMessages4 - FinishPoint");
	}
}
/* EventService.java
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.EventRepository;
import domain.Customer;
import domain.Event;
import domain.Organiser;

@Service
@Transactional
public class EventService {

		// Managed repository -------------------------------------------------
	
		@Autowired
		private EventRepository eventRepository;
		
		// Supporting services ------------------------------------------------
		
		@Autowired
		private CustomerService customerService;
		@Autowired
		private OrganiserService organiserService;
		
		// Constructors -------------------------------------------------------
		
		public EventService() {
			super();
		}

		// Simple CRUD methods ------------------------------------------------
		
		public Event create() {
			Event result;
			Organiser organiser;
			Date moment;
			
			organiser = organiserService.findByPrincipal();
			moment = new Date();
			
			result = new Event();			
			result.setTitle("New event");
			result.setMoment(moment);
			result.setDescription("");
			result.setPrice(0.00);
			result.setOrganiser(organiser);			
			
			return result;
		}
		
		public Collection<Event> findAll() {
			Collection<Event> result;
			
			result = eventRepository.findAll();
			
			return result;
		}
		
		public Event findOne(int eventId) {
			Event result;
			
			result = eventRepository.findOne(eventId);
			
			return result;
		}	
	
		public void save(Event event) {
			assert event != null;
			
			checkPrincipal(event);
			eventRepository.save(event);			
		}

		public void delete(Event event) {
			assert event != null;
			
			checkPrincipal(event);
			Assert.isTrue(event.getCustomers().isEmpty());
			eventRepository.delete(event.getId());
		}

		// Other business methods ---------------------------------------------
		
		public Event findOneToEdit(int id) {
			Event result;
			
			result = eventRepository.findOne(id);
			checkPrincipal(result);
			
			return result;
		}		

		public Collection<Event> findRegistered() {
			Collection<Event> result;
			Customer customer;
			
			customer = customerService.findByPrincipal();			
			result = eventRepository.findByCustomerId(customer.getId());
			
			return result;
		}
				
		public Collection<Event> findNotRegistered() {
			Collection<Event> result;
			Customer customer;
			
			customer = customerService.findByPrincipal();			
			result = eventRepository.findByNotCustomerId(customer.getId());			
			
			return result;
		}
		
		public Collection<Event> findOrganised() {
			Collection<Event> result;
			Organiser organiser;
			
			organiser = organiserService.findByPrincipal();			
			result = eventRepository.findByOrganiserId(organiser.getId());			
			
			return result;
		}
		
		public void register(int eventId) {
			Customer customer;
			Collection<Customer> customers;
			Event event;
			Collection<Event> events;
			Date currentMoment;
			
			customer = customerService.findByPrincipal();
			events = customer.getEvents();
			event = eventRepository.findOne(eventId);
			customers = event.getCustomers();		
			
			Assert.isTrue(!events.contains(event));
			currentMoment = new Date();		
			Assert.isTrue(currentMoment.before(event.getMoment()));
			
			events.add(event);
			customers.add(customer);
			// Not necessary: customerService.save(customer);
			eventRepository.save(event);
		}

		public void unregister(int eventId) {
			Customer customer;
			Collection<Customer> customers;
			Event event;
			Collection<Event> events;
			Date currentMoment;
			
			customer = customerService.findByPrincipal();
			events = customer.getEvents();
			event = eventRepository.findOne(eventId);
			customers = event.getCustomers();		
			
			Assert.isTrue(events.contains(event));
			currentMoment = new Date();
			Assert.isTrue(currentMoment.before(event.getMoment()));
			
			events.remove(event);
			customers.remove(customer);
			// Not necessary: customerService.save(customer);	
			eventRepository.save(event);		
		}
		
		protected void checkPrincipal(Event event) {
			assert event != null;
			
			Organiser organiser;
			
			organiser = organiserService.findByPrincipal();
			Assert.isTrue(event.getOrganiser().equals(organiser));			
		}

}

/* EventController.java
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers.customer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.EventService;
import controllers.AbstractController;
import domain.Event;

@Controller
@RequestMapping("/event/customer")
public class EventCustomerController extends AbstractController {
	
	// Services ---------------------------------------------------------------
	
	@Autowired
	private EventService eventService;
		
	// Constructors -----------------------------------------------------------
	
	public EventCustomerController() {
		super();
	}
	
	// Listing ----------------------------------------------------------------

	@RequestMapping("/list-registered")
	public ModelAndView listRegistered() {
		ModelAndView result;
		Collection<Event> events;
		
		events = eventService.findRegistered();		
		result = new ModelAndView("event/list");
		result.addObject("events", events);
		result.addObject("registered", true);
		result.addObject("requestURI", "event/customer/list-registered.do");
		
		return result;
	}
	
	@RequestMapping("/list-not-registered")
	public ModelAndView listNotRegistered() {
		ModelAndView result;
		Collection<Event> events;
		
		events = eventService.findNotRegistered();		
		result = new ModelAndView("event/list");
		result.addObject("events", events);
		result.addObject("registered", false);
		result.addObject("requestURI", "event/customer/list-not-registered.do");		
		
		return result;
	}	
				
	// Creation ---------------------------------------------------------------
		
	// Edition ----------------------------------------------------------------
		
	// Registration -----------------------------------------------------------
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam int eventId) {
		ModelAndView result;		
				
		try {			
			eventService.register(eventId);
			result = listNotRegistered();
			result.addObject("message", "event.commit.ok");			
		} catch (Throwable oops) {			
			result = listNotRegistered();
			result.addObject("message", "event.commit.error");			
		}
		
		return result;
	}
	
	@RequestMapping(value = "/unregister", method = RequestMethod.GET)
	public ModelAndView unregister(@RequestParam int eventId) {
		ModelAndView result;		
				
		try {
			eventService.unregister(eventId);
			result = listRegistered();			
			result.addObject("message", "event.commit.ok");
		} catch (Throwable oops) {
			result = listRegistered();
			result.addObject("message", "event.commit.error");			
		}
		
		return result;
	}
		
}
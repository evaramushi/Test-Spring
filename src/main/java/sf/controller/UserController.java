package sf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sf.dto.UserGetDto;
import sf.dto.UserPatchDto;
import sf.dto.UserPostDto;
import sf.entities.User;
import sf.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String viewHomePage(Model model){
		List<UserGetDto>	list = userService.getAll();
		
		for(UserGetDto usr: list) {
			System.out.println("User print: "+ usr);
		}
		
		model.addAttribute("list",list);
			 return "index";
		}
	
	@RequestMapping(value="/newUser", method=RequestMethod.GET)
	public String showNewUser(Model model) {
		UserPostDto user = new UserPostDto();
		model.addAttribute("user",user);
		
		return "addUser";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") UserPostDto user) {
		userService.save(user);
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/editUser/{id}")
	public String editUser(@PathVariable int id, Model model)
	{
		UserPatchDto user = userService.getUserPatch(id);
		model.addAttribute("user", user);
		
		return "updateUser";
		
	}
	
	@RequestMapping(value="editUser", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") UserPatchDto user) {
	int userId = user.getId();
		
		userService.update(userId, user);
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteUser/{id}" , method=RequestMethod.GET)
	public String deleteUser (@PathVariable int id) {
		userService.deleteUser(id);
		
		return "redirect:/";
	}
	
}

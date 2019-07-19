package com.quiz.QuizSpring;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController 
{

	DataBaseUtility dbUtil= new DataBaseUtility();
	
	@RequestMapping("/login")
	public String login(@PathParam("username")String username,@PathParam("password")String password, Model model)
	{
		return "quiz.html";
	}

	

}

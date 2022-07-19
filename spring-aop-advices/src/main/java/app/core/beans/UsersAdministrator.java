package app.core.beans;

import org.springframework.stereotype.Component;

import app.core.annotations.MyLogAnnotation;

@Component
@MyLogAnnotation // means that all method in this class are to be intercepted by matched advice
public class UsersAdministrator {

	public void addUser() {
		System.out.println("user added");
	}

	public void removeUser() {
		System.out.println("user removed");
	}

	public void blockUser() {
		System.out.println("user blocked");
	}

}

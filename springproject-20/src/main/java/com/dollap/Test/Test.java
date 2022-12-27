package com.dollap.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dollap.entity.User;
import com.dollap.repo.UserRepo;
@Component
public class Test implements CommandLineRunner{
@Autowired
UserRepo ur;
Scanner sc = new Scanner(System.in);
ArrayList<User> al = new ArrayList<User>();
	@Override
	public void run(String... args) throws Exception {
		System.out.println(ur.getClass().getName());
		
		while(true)
		{
			System.out.println("press 1 for insert User");
			System.out.println("press 2 for insert Multiple User");
			System.out.println("press 3 for Search User");
			System.out.println("press 4 for show list of all User");
			System.out.println("press 5 for Update User");
			System.out.println("press 6 for delete User");
			System.out.println("press 7 for delete all User");
			System.out.println("press 8 for Exit");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				inserUser();
				break;
				
			case 2:
				insertMultipleUser();
				break;	
				
			case 3:
				searchUser();
				break;
				
			case 4:
				showAllUser();
				break;
				
			case 5:
				updateUser();
				break;
				
			case 6:
				deleteUser();
				break;
			
			case 7:
				deleteAllUser();
				break;
			
			case 8:
				System.exit(0);
				
			default:
				System.out.println("It's your wrong choice.....enter valid choice");
				break;
			}
		}
	}
	private void deleteAllUser() {
		ur.deleteAll();
		System.out.println("delete all user sucessfully");
		
	}
	private void deleteUser() {
		System.out.println("enter user ID for delete the user");
		int id = sc.nextInt();
	    ur.deleteById(id);
		System.out.println("delete user sucessfully");
		
	}
	private void updateUser() {
		System.out.println("enter user ID for update the user");
		int id = sc.nextInt();
		Optional<User> it = ur.findById(id);
		User user = it.get();
		System.out.println("enter user id");
		int id1 = sc.nextInt();
		user.setUserId(id1);
		System.out.println("enter user name");
		sc.nextLine();
		String name = sc.nextLine();
		user.setUserName(name);
		System.out.println("enter user email");
		String email = sc.nextLine();
		user.setUserEmail(email);
		System.out.println("enter user status");
		String status = sc.nextLine();
		user.setUserStatus(status);
		ur.save(user);
	}
	private void showAllUser() {
		Iterable<User> it = ur.findAll();
		System.out.println(it);
		
	}
	private void searchUser() {
		System.out.println("enter user ID for search the user");
		int id = sc.nextInt();
		Optional<User> it = ur.findById(id);
		System.out.println(it);
		
		
	}
	private void insertMultipleUser() {
		System.out.println("please enter number of user to insert");
		int num = sc.nextInt();
		while(num--!=0)
		{
			System.out.println("enter user ID");
			 Integer id = sc.nextInt();
			 System.out.println("enter user Name"); 
			 sc.nextLine();
			 String name = sc.nextLine();
			 System.out.println("enter user Email");
			 String email = sc.nextLine();
			 System.out.println("enter user Status");
			 String status = sc.nextLine();
			 User user = new User(id,name,email,status);
			 al.add(user);	
		} 
		ur.saveAll(al);
		
	}
	private void inserUser() {
		System.out.println("enter user ID");
		 Integer id = sc.nextInt();
		 System.out.println("enter user Name"); 
		 sc.nextLine();
		 String name = sc.nextLine();
		 System.out.println("enter user Email");
		 String email = sc.nextLine();
		 System.out.println("enter user Status");
		 String status = sc.nextLine();
		 User user = new User(id,name,email,status);
		 ur.save(user);
		 
		
	}
	

}

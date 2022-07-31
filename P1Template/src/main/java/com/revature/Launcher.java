package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
import com.revature.controllers.StatusController;
import com.revature.controllers.UserController;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create(
				
				config -> {
					config.enableCorsForAllOrigins(); 
				}
				
				).start(3000); 
		
		AuthController ac = new AuthController();
		
		ReimbController rec = new ReimbController();
		
		UserController uc = new UserController();
		
		StatusController sc = new StatusController();
		
		app.get("/status", sc.getStatusHandler);
		
		app.get("/users", uc.getUsersHandler);
		
		app.get("/reimbursements", rec.getAllReimbHandler);
		
		app.get("/reimbursements/:status", rec.getReimbusementsHandler);
		
//		app.get("/reimbursement/:user_id", rec.getReimbursementsByAuthorHandler);
		
		app.post("/reimbursements", rec.insertReimbursementHandler);
		
		app.put("reimbursements/:reimb_id/approve", rec.approveReimbursementHandler);
		
		app.put("reimbursements/:reimb_id/deny", rec.denyReimbursementHandler);
		
		app.delete("reimbursements/:reimb_id", rec.deleteReimbursementHandler);
		
		
		
		
		app.post("/login", ac.loginHandler);
		
		app.post("/signup", uc.insertUserHandler);
		
		app.delete("/logout", ac.logoutHandler);
			
		//Welcome to P1! 
		
		//If you're reading this, you've successfully cloned your repo and imported the template
		
		//Do you coding in this project, and don't forget to save/push your progress with:
		//git add.
		//git commit -m"message"
		//git push
		
		//yes, you WILL need to push to your repo. The clients will want to see your project repos in your portfolios.
		
		//here's a dog to help you on your way. Have fun!
		
//               __
//          (___()'`;
//          /,    /`
//          \\"--\\
		
	}
	
}

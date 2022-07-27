package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
import com.revature.controllers.RoleController;
import com.revature.controllers.StatusController;
import com.revature.controllers.TypeController;
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
		
		RoleController rc = new RoleController();
		
		ReimbController rec = new ReimbController();
		
		StatusController sc = new StatusController();
		
		TypeController tc = new TypeController();
		
		UserController uc = new UserController();
		
		if (ac.ses != null) {
			
			app.get("/reimbursement", rec.getReimbusementsHandler);
			
			app.get("/reimbursement/:username", rec.getReimbusementsByAuthorHandler);
			
			app.post("/reimbursement", rec.insertReimbursementHandler);
			
			app.put("/reimbursement/:reimb_id", rec.updateReimbursementStatusHandler);
			
			app.delete("reimbursement/:reimb_id", rec.deleteReimbursementHandler);
			
		} else {
			
			app.post("/login", ac.loginHandler);
			
			app.post("/signup", uc.insertUserHandler);
			
			
		}
		
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

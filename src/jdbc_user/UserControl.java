package jdbc_user;

import java.util.Scanner;

public class UserControl {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		UserCRUD userCRUD = new UserCRUD();
		System.out.println("Welcome User!");
		for (;;) {
			System.out.println("1. Signup \n2. Login \n3. Exit");
			System.out.println("Enter the option for your application:");
			try {
				Scanner scanner = new Scanner(System.in);
				int ip = scanner.nextInt();
				switch (ip) {
				case 1: {
					System.out.println("Enter the id:");
					int id = scanner.nextInt();
					System.out.println("Enter the name:");
					String name = scanner.next();
					System.out.println("Enter Phone number:");
					long number = scanner.nextLong();
					System.out.println("Enter email id:");
					String emailId = scanner.next();
					System.out.println("Enter the Password:");
					String password = scanner.next();
					user.setId(id);
					user.setName(name);
					user.setNumber(number);
					user.setEmailId(emailId);
					user.setPassword(password);
					userCRUD.signUp(user);
					break;
				}
				case 2: {
					System.out.println("Enter email id:");
					String emailId = scanner.next();
					user.setEmailId(emailId);
					for (int i = 0; i < 6; i++) {
						System.out.println("Enter the Password:");
						String password = scanner.next();
						user.setPassword(password);
						int opt = 0;
						int opt1=0;
						if (userCRUD.logIn(emailId, password) == 1) {
							System.out.println("Login Successful!");
							outerloop2:
							for (;;) {
								System.out.println("1.Update \n2.Display password \n3.Logout");
								opt = scanner.nextInt();
								switch (opt) {
								case 1: {
									outerloop3:
									for (;;) {
										System.out.println("1. Facebook password \n2. Instagram password \n3. X password \n4. exit");
										int j = scanner.nextInt();
										switch (j) {
										case 1: {
											System.out.println("Enter the password:");
											userCRUD.updatePassword(j, emailId, scanner.next());
											break;
										}
										case 2: {

											System.out.println("Enter the password:");
											userCRUD.updatePassword(j, emailId, scanner.next());
											break;
										}
										case 3: {
											System.out.println("Enter the password:");
											userCRUD.updatePassword(j, emailId, scanner.next());
											break;
										}
										case 4:{
											break;
										}
										default:{
											System.out.println("Entered option is incorrect!");
											continue outerloop3;
										}
											
										}
										if (j == 4) {
											break;
										}
									}
									break;
								}
								case 2: {

									userCRUD.showPassword(emailId);
									break;
								}
								case 3: {
									break;
								}
								default:{
									System.out.println("Entered option is incorrect!");
									continue outerloop2;								
								}
								}
								if (opt == 3) {
									break;
								}
							}
						}
						if (opt == 3) {
							System.out.println("Logout!");
							break;
						}
						else if (userCRUD.logIn(emailId, password) == -1) {
							System.out.println("Login fail!\n1. Enter correct password! \n2. Forgot password \n3. exit");
							opt1 = scanner.nextInt();
							int fp=0;
							switch (opt1) {
							case 1: {
								if (i == 5) {
									System.out.println("Reached limit!");
									break;
								}
								break;
							}
							case 2: {
								System.out.println("Enter the email Id");
								scanner.next();
								System.out.println("Enter new password:");
								String newPassword = scanner.next();
								fp=userCRUD.forgotPassword(emailId, newPassword);
								break;
							}
							}
							if(fp==1) {
								break;
							}
							if (opt1 == 3) {
								break;
							}

						} else {
							System.out.println("Email is not resistered! Signup First!");
							break;
						}

					}

					break;
				}
				case 3:{
					System.out.println("Thank you!");
					System.exit(0);
				}
				default: {
					System.out.println("Enter correct option!");
				}

				}
			} catch (Exception e) {
				System.out.println("Give correct input.");
			}
			
		}
	}
}

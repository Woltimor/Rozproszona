import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
public class InsertInto {
	public static void main(String[] args) {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random rnd = new Random();
        
		String fileName = "out.txt";
		String fileName2 = "out2.txt";
		try {

			PrintWriter outputStream = new PrintWriter(fileName);
			PrintWriter outputStream2 = new PrintWriter(fileName2);
			
			for(int i = 500000;i<501000;i++) {
		        StringBuilder salt = new StringBuilder();

				while (salt.length() < 8) { // length of the random string.
		            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		            salt.append(SALTCHARS.charAt(index));
		        }
				
				String nrRej = salt.toString();
		 
				outputStream2.print("Insert into Rejestracja(Id_egzemplarza,Id_osoby,Numer_rejestracyjny) values(" + i +","+i%1000 +",'"+nrRej+"');");
				outputStream2.print("\n");
			}


			for(int i = 1;i<10000;i++) {
		        StringBuilder salt = new StringBuilder();
		        StringBuilder salt2 = new StringBuilder();

				while (salt.length() < 18) { // length of the random string.
		            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		            salt.append(SALTCHARS.charAt(index));
		        }
				while (salt2.length() < 10) { // length of the random string.
		            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		            salt2.append(SALTCHARS.charAt(index));
		        }
				String saltStr = salt.toString();
				String saltStr2 = salt2.toString();
				 
		 
				outputStream.print("Insert into EgzemplarzSamochod(Id_slownika,Numer_podwozia,Numer_silnika) values(" + i%1000 +",'"+saltStr +"','"+saltStr2+"');");
				outputStream.print("\n");
			}
			
			
			
			
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}

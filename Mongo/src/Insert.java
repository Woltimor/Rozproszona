import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Insert {
	public static void main(String[] args) {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random rnd = new Random();
        Long max =0L;
        Long min =100000000000L;
        List Marka = new ArrayList();
        List Model = new ArrayList();
        List Imie = new ArrayList();
        List Nazwisko = new ArrayList();
        List Adres = new ArrayList();
        
        SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
        List<Car> cars = readBooksFromCSV("books.txt");
        List<Person> people = readPersonFromCsv("mydata.txt");
		String fileName = "mongo.txt";
		for(Person p : people) {
		Adres.add(p.getAddress());
		Imie.add(p.getName());
		Nazwisko.add(p.getSurname());

		}
		for(Car c : cars) {
			Marka.add(c.getMarka());
			Model.add(c.getModel());
		}
		try {
			int j =0;

			PrintWriter outputStream = new PrintWriter(fileName);
			for(int i = 0;i<100000;i++) {
				
				
				Random r = new Random();
				Random d = new Random();
	            Long randomLong=(r.nextLong() % (max - min)) + min;
	            Long randomLong2=(d.nextLong() % (max - min)) + min;
	            Date dt =new Date(randomLong);
	            Date dt2 =new Date(randomLong2);
	            


		        StringBuilder salt = new StringBuilder();
		        StringBuilder salt2 = new StringBuilder();
		        StringBuilder salt3 = new StringBuilder();

				while (salt.length() < 18) { // length of the random string.
		            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		            salt.append(SALTCHARS.charAt(index));
		        }
				while (salt2.length() < 10) { // length of the random string.
		            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		            salt2.append(SALTCHARS.charAt(index));
		        }
				while (salt3.length() < 8) { // length of the random string.
		            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		            salt3.append(SALTCHARS.charAt(index));
		        }
				String saltStr = salt.toString();
				String saltStr2 = salt2.toString();
				String saltStr3 = salt3.toString();

				outputStream.print("{");
				outputStream.print("\n");
				outputStream.print("\"NumerSilnika\" : \""+saltStr+"\"," );
				outputStream.print("\n");
				outputStream.print("\"NumerPodwozia\" : \""+saltStr2+ "\"," );
				outputStream.print("\n");
				outputStream.print("\"RokProdukcji\" :\""+spf.format(dt)+ "\"," );
				outputStream.print("\n");
				outputStream.print("\"Typ\" :{" );
				outputStream.print("\n");
				outputStream.print("\"Marka\" :\""+Marka.get(r.nextInt(1+1000))+ "\"," );
				outputStream.print("\n");
				outputStream.print("\"Model\" :\""+Model.get(r.nextInt(1+1000))+ "\"\n}," );
				outputStream.print("\n");
				outputStream.print("\"Rejestracja\" :{" );
				outputStream.print("\n");
				outputStream.print("\"Imie\" :\""+Imie.get(r.nextInt(1+1000))+ "\"," );
				outputStream.print("\n");
				outputStream.print("\"Nazwisko\" :\""+Nazwisko.get(r.nextInt(1+1000))+ "\"," );
				outputStream.print("\n");
				outputStream.print("\"Pesel\" :\""+r.nextInt(400000+999999)+r.nextInt(11111+99999)+ "\"," );
				outputStream.print("\n");
				outputStream.print("\"Adres\" :\""+Adres.get(r.nextInt(1+1000))+ "\"," );
				outputStream.print("\n");
				outputStream.print("\"NumerRejestracyjny\" :\""+saltStr3+ "\"," );
				outputStream.print("\n");
				outputStream.print("\"DataRejestracji\" :\""+spf.format(dt2)+ "\"\n }" );
				outputStream.print("\n},");
				outputStream.print("\n");


			}
			
			
			
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}



	private static List<Car> readBooksFromCSV(String fileName3) {
		List<Car> cars = new ArrayList<>();

		Path pathToFile = Paths.get(fileName3);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.ISO_8859_1)) {
        	
            String line = br.readLine();
            while (line != null) {

                String[] attributes = line.split(",");

                Car car = createCar(attributes);
                cars.add(car);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cars;
	}
	private static Car createCar(String[] metadata) {
        String Marka = metadata[0];
        String Model = metadata[1];
        return new Car(Marka, Model);
    }
	
	
	
	
	
	private static List<Person> readPersonFromCsv(String fileName4) {
		List<Person> people = new ArrayList<>();

		Path pathToFile = Paths.get(fileName4);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.ISO_8859_1)) {
        	
            String line = br.readLine();
            while (line != null) {

                String[] attributes = line.split(",");

                Person person = createPerson(attributes);
                people.add(person);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return people;
	}
	private static Person createPerson(String[] metadata) {
        String Address = metadata[0];
        String Name = metadata[1];
        String Surname = metadata[2];
        return new Person(Name, Surname,Address);
    }

}
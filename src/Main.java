import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //Declares list for Student objects to be added to
        List<Student> students = new ArrayList<>();

        //Declares Gson object for json reading
        Gson gson = new Gson();

        //Makes filePath a variable for easier use
        String filePath = "Students.json";

        //Wow

        //Declares FileReader so it can be used outside of try scope
        FileReader file = null;

        //Makes sure file is there
        try {
            file = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Makes sure file is formatted correctly
        try {
            //Uses Gson to add the Json data to a list of objects
            students = gson.fromJson(file, new TypeToken<List<Student>>(){}.getType());
        } catch (JsonIOException | JsonSyntaxException e) {
            System.out.println("Invalid JSON Syntax: \n\n" + e.getMessage());
        }

        //Loops through list and prints out student data
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
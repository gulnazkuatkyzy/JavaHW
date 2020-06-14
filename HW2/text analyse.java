import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;





public class CreateFile {
    public static void main(String[] args) {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
class ReadFile {
    public static void main(String[] args) {
        File myObj = new File("filename.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }
}

class ReplaceInFile {
    public static void main(String[] args) throws IOException {
        String fileName = "book.txt";
        String search = "число ПИ";
        String replace = "Алиса";
        Charset charset = StandardCharsets.UTF_8;
        Path path = Paths.get(fileName);
        Files.write(path,
                new String(Files.readAllBytes(path), charset).replace(search, replace)
                        .getBytes(charset));
    }
}

class RepeatedWordInFile
{
    public static void main(String[] args)
    {
        //Creating wordCountMap which holds words as keys and their occurrences as values

        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();

        BufferedReader reader = null;

        try
        {
            //Creating BufferedReader object

            reader = new BufferedReader(new FileReader("book.txt"));

            //Reading the first line into currentLine

            String currentLine = reader.readLine();

            while (currentLine != null)
            {
                //splitting the currentLine into words

                String[] words = currentLine.toLowerCase().split(" ");

                //Iterating each word

                for (String word : words)
                {
                    //if word is already present in wordCountMap, updating its count

                    if(wordCountMap.containsKey(word))
                    {
                        wordCountMap.put(word, wordCountMap.get(word)+1);
                    }

                    //otherwise inserting the word as key and 1 as its value
                    else
                    {
                        wordCountMap.put(word, 1);
                    }
                }

                //Reading next line into currentLine

                currentLine = reader.readLine();
            }

            //Getting the most repeated word and its occurrence

            String mostRepeatedWord = null;

            int count = 0;

            Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();

            for (Entry<String, Integer> entry : entrySet)
            {
                if(entry.getValue() > count)
                {
                    mostRepeatedWord = entry.getKey();

                    count = entry.getValue();
                }
            }

            System.out.println("The most repeated word in input file is : "+mostRepeatedWord);

            System.out.println("Number Of Occurrences : "+count);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();           //Closing the reader
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class Exercise18 {
    public static void main(String [ ] args) throws FileNotFoundException {
        new Exercise18().findLongestWords();
    }

    public String findLongestWords() throws FileNotFoundException {

        String longest_word = "";
        String current;
        Scanner sc = new Scanner(new File("book.txt"));


        while (sc.hasNext()) {
            current = sc.next();
            if (current.length() > longest_word.length()) {
                longest_word = current;
            }

        }
        System.out.println("\n"+longest_word+"\n");
        return longest_word;
    }
}

class CountWordFile {
    public static void main(String[] args) throws Exception {
        String line;
        int count = 0;

        //Opens a file in read mode
        FileReader file = new FileReader("book.txt");
        BufferedReader br = new BufferedReader(file);

        //Gets each line till end of file is reached
        while((line = br.readLine()) != null) {
            //Splits each line into words
            String words[] = line.split(" ");
            //Counts each word
            count = count + words.length;
        }

        System.out.println("Number of words present in given file: " + count);
        br.close();
    }
}
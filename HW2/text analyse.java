import java.io.File;
import java.io.IOException;
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
        String search = "Alice";
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
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();

        BufferedReader reader = null;

        try
        {
            reader = new BufferedReader(new FileReader("book.txt"));

           String currentLine = reader.readLine();

            while (currentLine != null)
            {
                String[] words = currentLine.toLowerCase().split(" ");

                for (String word : words)
                {

                    if(wordCountMap.containsKey(word))
                    {
                        wordCountMap.put(word, wordCountMap.get(word)+1);
                    }

                    else
                    {
                        wordCountMap.put(word, 1);
                    }
                }

                currentLine = reader.readLine();
            }

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
                reader.close();
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

        FileReader file = new FileReader("book.txt");
        BufferedReader br = new BufferedReader(file);

        while((line = br.readLine()) != null) {
            String words[] = line.split(" ");
            count = count + words.length;
        }

        System.out.println("Number of words present in given file: " + count);
        br.close();
    }
}
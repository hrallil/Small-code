import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] intarray = {5,33,42,2,6,57,9,4,8};
        List<String> Names = new ArrayList<>();
        Names.add( "Ulla");
        Names.add("Albert");
        Names.add("Alfred");
        Names.add("Berta");
        Names.add("Lucy");
        Names.add("Anya");

        List<Integer> intList = new ArrayList<>();
        Integer[] num = {1,43,56,6,23,4,7,43,7,654,3};
        for (int i = 0; i < 10; i++) {
            
            intList.add(num[i]);
        }
        System.out.println("intlist: " + SearchMethods.JumpSearch(intList, 23));

        Integer index=SearchMethods.SequencialSearch(intarray,42);
        System.out.println(" The index of 42 in intarray is "+index+" and contains: "+intarray[index]);
        Integer[] intSortarray = {2,4,5,6,8,9,33,42,57};
        index = SearchMethods.JumpSearch(intSortarray,9);
        System.out.println(" The index of 9 in intsortedarray is "+index+" and contains: "+intSortarray[index]);
	    // write your code here

        List<Student> listOfStudents = new ArrayList<Student>();

        listOfStudents.add(new Student("Jess", 18, 10.3));
        listOfStudents.add(new Student("carl", 20, 6.4));
        listOfStudents.add(new Student("Mathais", 22, 2.7));
        listOfStudents.add(new Student("Martin", 1132, 12.5));
        listOfStudents.add(new Student("Fin", 24, 7.3));
        Student studentToFind = listOfStudents.get(3);

        index = SearchMethods.binarySearch(listOfStudents, studentToFind, 0, listOfStudents.size() - 1);
        System.out.println(index);
        if(index != null){
            System.out.println("index of " + listOfStudents.get(index).getName() + " is " + index);
        }

        
        
        
    }
}

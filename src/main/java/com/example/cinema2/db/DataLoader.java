package com.example.cinema2.db;

import com.example.cinema2.entity.FilmEntity;
import com.example.cinema2.entity.RoomEntity;
import com.example.cinema2.entity.SeatEntity;
import com.example.cinema2.entity.UserEntity;
import com.example.cinema2.repo.*;
import com.example.cinema2.utility.TicketUtility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        RoomEntity room = new RoomEntity();
        room.setName("Room1");
        room.setTotalSeats(60L);
        roomRepository.save(room);

        FilmEntity film = new FilmEntity();
        film.setName("Film1");
        film.setDuration(200L);
        film.setType3D(false);
        film.setRoom(room);

        filmRepository.save(film);

        room.setFilm(film);

        int num = 0;
        int letter= 0;
        List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F");
        List<SeatEntity> seats = new ArrayList<>();
        for(int i=0; i<60; i++ ){
            num++;
            SeatEntity seat = new SeatEntity();
            StringBuilder builder = new StringBuilder();
            if(i%10==0 && i!=0){
                letter++;
                num = 1;
            }
            String letterS = letters.get(letter);
            seat.setSeatNumber(String.valueOf(builder.append(letterS).append("-").append(num)));
            seat.setRoom(room);
            seat.setOccupied(false);
            seatRepository.save(seat);
            seats.add(seat);
        }
        room.setSeats(seats);
        roomRepository.save(room);

        UserEntity serhii = new UserEntity();
        serhii.setUsername("Serhii");
        serhii.setPassword(passwordEncoder.encode("123"));
        serhii.setRole("admin");
        userRepository.save(serhii);

        //------------------
//        Comparator<Integer> comparator = (o1, o2) -> o2.compareTo(o1);
//        TreeSet<Integer> numbers = new TreeSet<>(comparator);
//        numbers.add(3);
//        numbers.add(2);
//        numbers.add(10);
//        numbers.add(5);
//        System.out.println(numbers);
        //------------------------
//        Comparator<String> comparator = (o1, o2) -> {
//            if(o1.length()==o2.length()){
//                return o1.compareTo(o2);
//            }
//             return Integer.compare(o1.length(),o2.length());
//        };
//        TreeSet<String> words = new TreeSet<>(comparator);
//        words.add("Anderea");
//        words.add("Silvestr");
//        words.add("Domitrii");
//        words.add("Dimitrii");
//        words.add("Alice");
//        words.add("Bob");
//        System.out.println(words);

        // ordina per nome desc, eta asc, if name== age== -> desc;
//        Comparator<Person> comparator = (o1, o2) -> {
//            o2.getName().compareToIgnoreCase(o1.getName());
//            if(o1.getName() == o2.getName() && o1.getAge() != o2.getAge()){
//                return o1.getAge() - o2.getAge();
//            }else if(o1.getName() == o2.getName())
//                return o2.getBirth().isBefore(o1.getBirth()) ? 1 : -1;
//            return o2.getName().compareToIgnoreCase(o1.getName());
//        };
//        TreeSet<Person> persons = new TreeSet<>(comparator);
//
//        Person person1 = new Person("Alice",11,LocalDate.now().minusYears(5));
//        Person person6 = new Person("Alice",11,LocalDate.now().minusYears(10));
//        Person person5 = new Person("Antonio",5,LocalDate.now().minusYears(7));
//        Person person3 = new Person("Charlie",8,LocalDate.now().minusYears(13));
//        Person person2 = new Person("Bob",23,LocalDate.now().minusYears(25));
//        Person person4 = new Person("David",93,LocalDate.now().minusYears(99));
//        persons.add(person1);
//        persons.add(person6);
//        persons.add(person5);
//        persons.add(person3);
//        persons.add(person2);
//        persons.add(person4);
//        System.out.println(persons);
        //------------------------
//        Map<String,Integer> map = new HashMap<>();
//        map.put("B", 2);
//        map.put("C", 3);
//        map.put("A", 1);
//        map.put("D", 4);
//        map.entrySet().forEach(item -> System.out.println(item.getKey() + " " + item.getValue()));

//        Map<String,Integer> newMap = new TreeMap<>();
//        newMap.put("A", 1);
//        newMap.put("C", 3);
//        newMap.put("B", 2);
//        newMap.entrySet().forEach(item -> System.out.println(item.getKey() + " " + item.getValue()));
        //----------------------
//        String names = "cane,gatto,papagallo,orso,lince";
//        Map<String,Integer> namesMap = new TreeMap<>();
//        List<String> keys = List.of(names.split(","));
//        int nums = 0;
//        for(String key : keys){
//            if(!namesMap.containsKey(key)){
//                namesMap.put(key, nums++);
//            }else{
//                Integer i = namesMap.get(key);
//                namesMap.put(key, i++);
//            }
//        }
//        System.out.println(namesMap);
        //-------------------
//        Comparator<Integer> comparator = (o1,o2) -> o2 - o1;
//
//        Map<Integer,String> marks = new TreeMap<>(comparator);
//        marks.put(5,"Andrea");
//        marks.put(10,"Sebastiano");
//        marks.put(8,"Elisabetta");
//        marks.put(2,"Michelle");
//        marks.put(6,"Romeo");
//        System.out.println(marks);

//        Map<String,Integer> marksLink = new LinkedHashMap<>();
//        marksLink.put("Andrea",5);
//        marksLink.put("Sebastiano",10);
//        marksLink.put("Elisabetta",8);
//        marksLink.put("Michelle",2);
//        marksLink.put("Romeo",6);
//
//        System.out.println(marksLink);






    }
//    @Data
//    @AllArgsConstructor
//    class Person {
//        String name;
//        int age;
//        LocalDate birth;
//    }



}

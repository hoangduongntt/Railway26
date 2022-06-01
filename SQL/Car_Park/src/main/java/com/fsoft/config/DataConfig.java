package com.fsoft.config;

import com.fsoft.entity.*;
import com.fsoft.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Configuration
public class DataConfig {
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, TripRepository tripRepository, TicketRepository ticketRepository,
                                   ParkinglotRepository parkinglotRepository, CarRepository carRepository, BookingOfficeRepository bookingOfficeRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // Insert Employee
                Employee employee1 = new Employee("DuongHV", "IT", "Ha Noi", new Date("1994/03/03"), "hoangduong@gmail.com.vn", "Hoang Van Duong", "0989482422", "duong123", "M");
                Employee employee2 = new Employee("VuLD", "Sale", "Thanh Hoa", new Date("1995/07/23"), "ledinhvu@gmail.com.vn", "Le Dinh Vu", "0989482425", "vu123", "F");
                Employee employee3 = new Employee("TuyetNT", "Marketing", "Ha Noi", new Date("1998/08/13"), "nttuyet@gmail.com.vn", "Nguyen Thi Tuyet", "0989482412", "tuyet123", "F");
                Employee employee4 = new Employee("TruongPV", "HR", "Hai Phong", new Date("1995/08/13"), "pvtruong@gmail.com.vn", "Pham Van Truong", "0983482412", "truong123", "F");
                Employee employee5 = new Employee("CuongNV", "Security", "NinhBinh", new Date("1992/08/13"), "ntcuong@gmail.com.vn", "Nguyen Van ", "0985482412", "cuong123", "M");
                employeeRepository.save(employee1);
                employeeRepository.save(employee2);
                employeeRepository.save(employee3);
                employeeRepository.save(employee4);
                employeeRepository.save(employee5);


                //Insert Trip
                Trip trip1 = new Trip(3,"Honda", new Date("2021/03/12"),new Date("2021/03/12 10:30:00"),"Bắc Ninh","Dương",25 );
                Trip trip2 = new Trip(6,"Honda", new Date("2022/06/20"),new Date("2022/06/20 9:30:00"),"Hoà Bình","Tuyết",25 );
                Trip trip3 = new Trip(7,"Honda", new Date("2021/09/12"),new Date("2021/09/12 9:00:00"),"Hưng Yên","Vũ",25 );
                Trip trip4 = new Trip(4,"Honda", new Date("2021/09/12"),new Date("2021/09/12 9:20:00"),"Bắc Giang","Linh",30 );
                Trip trip5 = new Trip(8,"Honda", new Date("2021/09/12"),new Date("2021/09/12 9:00:00"),"Hà Nam","Quang",36 );
                tripRepository.save(trip1);
                tripRepository.save(trip2);
                tripRepository.save(trip3);
                tripRepository.save(trip4);
                tripRepository.save(trip5);

                //Insert Bọoking Office
                BookingOffice bookingOffice1 = new BookingOffice(new Date("2022/04/22"),"Duy Tân", "098942424","Cầu Giấy",20000,new Date("2022/04/13"));
                bookingOffice1.setTrip(trip1);
                BookingOffice bookingOffice2 = new BookingOffice(new Date("2022/04/23"),"Phạm Văn Bạch", "0989424256","Cầu Giấy",10000,new Date("2022/04/15"));
                bookingOffice2.setTrip(trip3);
                BookingOffice bookingOffice3 = new BookingOffice(new Date("2022/04/24"),"Hòa Lạc", "098942489","Thường Tín",50000,new Date("2022/04/14"));
                bookingOffice3.setTrip(trip1);
                BookingOffice bookingOffice4 = new BookingOffice(new Date("2022/04/25"),"Hòa Lạc", "098942489","Thường Tín",50000,new Date("2022/04/14"));
                bookingOffice4.setTrip(trip4);
                BookingOffice bookingOffice5= new BookingOffice(new Date("2022/04/26"),"Hòa Lạc", "098942489","Thường Tín",50000,new Date("2022/04/14"));
                bookingOffice5.setTrip(trip3);
                bookingOfficeRepository.save(bookingOffice1);
                bookingOfficeRepository.save(bookingOffice2);
                bookingOfficeRepository.save(bookingOffice3);
                bookingOfficeRepository.save(bookingOffice4);
                bookingOfficeRepository.save(bookingOffice5);



                //Insert Parkinglot
                Parkinglot  parkinglot1 = new Parkinglot(10, "Giảng đường A", "A1",5000, "Full");
                Parkinglot  parkinglot2 = new Parkinglot(11, "Giảng đường B", "B1",10000, "Blank");
                Parkinglot  parkinglot3 = new Parkinglot(12, "Giảng đường C", "C1",5000, "Full");
                Parkinglot  parkinglot4 = new Parkinglot(13, "Giảng đường D", "D1",5000, "Full");
                Parkinglot  parkinglot5 = new Parkinglot(14, "Giảng đường F", "F1",5000, "Blank");
                parkinglotRepository.save(parkinglot1);
                parkinglotRepository.save(parkinglot2);
                parkinglotRepository.save(parkinglot3);
                parkinglotRepository.save(parkinglot4);
                parkinglotRepository.save(parkinglot5);



                //Insert Car
                Car car1 = new Car("29B-7551","Red", "Honda", "FPT" );
                car1.setParkinglot(parkinglot3);
                Car car2 = new Car("30B-7551","White", "Toyota", "SamSung" );
                car2.setParkinglot(parkinglot2);
                Car car3 = new Car("29B-7671","Blue", "Lexeus", "Vietel" );
                car3.setParkinglot(parkinglot1);
                Car car4 = new Car("31B-7681","Red", "Hungdai", "CMC Global" );
                car4.setParkinglot(parkinglot2);
                Car car5 = new Car("29B-7451","Blue", "Nissan", "FPT" );
                car5.setParkinglot(parkinglot1);
                carRepository.save(car1);
                carRepository.save(car2);
                carRepository.save(car3);
                carRepository.save(car4);
                carRepository.save(car5);


               // Insert Ticket
                Ticket ticket1 = new Ticket(new Date("2022/04/22 9:00"), "KhanhDT",trip3, car1 );
                Ticket ticket2 = new Ticket(new Date("2022/04/22 10:00"), "DuongHV", trip2,car3);
                Ticket ticket3 = new Ticket(new Date("2022/04/22 11:00"), "VuLD",trip1,car2);
                Ticket ticket4 = new Ticket(new Date("2022/04/23 11:00"), "QuangLD",trip4,car5);
                Ticket ticket5 = new Ticket(new Date("2022/04/24 11:00"), "MinhNV",trip1,car2);
                ticketRepository.save(ticket1);
                ticketRepository.save(ticket2);
                ticketRepository.save(ticket3);
                ticketRepository.save(ticket4);
                ticketRepository.save(ticket5);

            }
            };
    }
}

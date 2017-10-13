import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.hibernate.annotations.SourceType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class RoomDataTest {
    RoomData roomData;

    @Before
    public void init(){
        roomData= new RoomData();
    }


    @Test
    public void searchApartmentForArea() throws Exception {
        System.out.println("Area 20");
        roomData.searchApartmentForArea(20);
    }

    @Test
    public void searchApartmentForCountRoom() throws Exception {
        System.out.println("Room 2");
        roomData.searchApartmentForCountRoom(2);
    }

    @Test
    public void searchApartmentForDistrict() throws Exception {
        System.out.println("District dist");
        roomData.addApartmentToDB(ApartmentBuilder.createApartmentForDistrict("dist"));
        roomData.searchApartmentForDistrict("dist");
    }

    @Test
    public void searchApartmentForAddress() throws Exception {
        System.out.println("Address address");
        roomData.addApartmentToDB(ApartmentBuilder.createApartmentForAddress("address"));
        roomData.searchApartmentForAddress("address");
    }

    @Test
    public void searchApartmentForPrice() throws Exception {
        System.out.println("Price 2000");
        roomData.searchApartmentForPrice(2000);
    }

//    @Test
//    public void searchApartmentForParam() throws Exception {
//        System.out.println("Param countRoom 1");
//        roomData.searchApartmentForParam("price",1000);
//    }

    @After
    public void close(){
        roomData.close();
    }

}
package presentation;

import business.SectionService;
import business.SectionServiceImpl;

public class Interface {

    private final SectionService service = SectionServiceImpl.getInstance();

    public void start(){

        service.getAll().forEach(System.out::println);

    }
}

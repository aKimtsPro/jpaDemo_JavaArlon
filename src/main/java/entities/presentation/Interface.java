package entities.presentation;

import entities.business.SectionService;
import entities.business.SectionServiceImpl;

public class Interface {

    private final SectionService service = SectionServiceImpl.getInstance();

    public void start(){

        service.getAll().forEach(System.out::println);

    }
}

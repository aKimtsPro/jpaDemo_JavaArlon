package business;

import business.mapper.SectionMapper;
import data.dao.SectionDAO;
import dto.SectionDTO;

import java.util.List;
import java.util.stream.Collectors;

public class SectionServiceImpl implements SectionService {

    private static SectionServiceImpl instance;
    public static SectionServiceImpl getInstance() {
        return instance == null ? instance = new SectionServiceImpl() : instance;
    }
    private SectionServiceImpl() {
    }

    private final SectionDAO dao = SectionDAO.getInstance();
    private final SectionMapper mapper = new SectionMapper();

    @Override
    public List<SectionDTO> getAll() {
        return dao.getAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}

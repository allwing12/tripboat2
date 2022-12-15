package tripboat.tripboat1.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TestServiceImple {
    @Autowired
    private TestMapper testMapper;
    private testRepository testRepository;

    }

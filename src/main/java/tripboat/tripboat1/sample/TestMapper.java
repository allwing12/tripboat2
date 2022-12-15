package tripboat.tripboat1.sample;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TestMapper {
    public int idCheck(String username);
}

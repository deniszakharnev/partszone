package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface FileUploadMapper {

    @Insert("INSERT INTO uploads (filename, handle_begin_time) VALUES (#{fileName}, #{startTime})")
    void startFileUpload(@Param("fileName") String fileName, @Param("startTime") Date startTime);
}

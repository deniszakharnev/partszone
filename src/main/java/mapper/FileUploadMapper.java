package mapper;

import domain.Upload;
import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface FileUploadMapper {

    @Insert("INSERT INTO uploads (filename, handle_begin_time) VALUES (#{fileName}, #{startTime})")
    @Options(useGeneratedKeys = true, keyColumn = "DBID")
    int startFileUpload(Upload upload);

    @Update("UPDATE uploads SET handle_end_time=#{stopTime} WHERE dbid=#{uploadId}")
    void stopFileUpload(@Param("stopTime") Date stopTime, @Param("uploadId") Integer uploadId);
}

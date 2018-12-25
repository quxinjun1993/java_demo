package swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swagger2.constant.ResponseServer;
import swagger2.model.Student;

import java.util.List;

@RestController
@RequestMapping("/student")
@Api(value = "StudentController", description = "学生接口")
public class StudentController {

    private Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/getAllStudentInfo")
    @ApiOperation(value = "获取所有学生信息", notes = "获取所有学生信息")
    public ResponseServer getAllStudentInfo(){
        String sql = "select * from student";
        logger.info(jdbcTemplate);
        List<Student> list =  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        return ResponseServer.createBySuccess(list);
    }
}

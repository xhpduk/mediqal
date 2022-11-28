package com.mediqal.community.mapper;


import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void updateTest(){
        UserVO userVO = userMapper.select(4L);
        userVO.setUserPassword("1234");
        userVO.setUserNickname("고래");
        userMapper.update(userVO);
    }

    @Test
    public void deleteTest(){
        userMapper.delete(8L);
    }

    @Test
    public void selectTest(){
        log.info("select : " + userMapper.select(2L));
    }

    @Test
    public void selectAllTest() {
        userMapper.selectAll().stream().map(UserVO::getUserName).forEach(log::info);
    }

    @Test
    public void insertTest() {
        UserVO userVO = new UserVO();
        userVO.create(0L,
                "hgd@naver.com",
                "1234",
                "홍길동",
                "홍홍길동",
                "email",
                "일반",
                "",
                "",
                "",
                "1");
        userMapper.insert(userVO);
    }

    @Test
    public void findPasswordTest() {
        log.info("userPassword" + userMapper.findPassword("ksy@naver.com"));
    }

    @Test
    public void checkIdTest() {
        log.info("아이디 중복개수" + userMapper.checkId("ksy@naver.com"));
    }

    @Test
    public void checkNickname() {
        log.info("닉네임 중복 개수" + userMapper.checkNickname("장장보고"));
    }


    @Test
    public void loginTest() {
        log.info("userNumber" + userMapper.login("ksy@naver.com", "1234"));

    }

    @Test
    public void profileSelect(){
        log.info("유저 정보" + userMapper.profileSelect((long) 1));
    }

    @Test
    public void profileUpdate(){
        UserDTO userDTO = new UserDTO();
        userDTO.create((long) 1,
                "4321",
                "이순신",
                "이이순신");
        userMapper.profileUpdate(userDTO);
        log.info("유저 업데이트");
    }

    @Test
    public void profileDelete(){
        userMapper.profileDelete((long) 1);
        log.info("회원 탈퇴");
    }

}
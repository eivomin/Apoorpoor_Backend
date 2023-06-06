package com.example.apoorpoor_backend.service;

import com.example.apoorpoor_backend.dto.account.MonthSumResponseDto;
import com.example.apoorpoor_backend.dto.account.TotalSumResponseDto;
import com.example.apoorpoor_backend.dto.user.MyPageSearchCondition;
import com.example.apoorpoor_backend.dto.user.UserResponseDto;
import com.example.apoorpoor_backend.model.User;
import com.example.apoorpoor_backend.repository.ledgerhistory.LedgerHistoryRepository;
import com.example.apoorpoor_backend.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LedgerHistoryRepository ledgerHistoryRepository;

    public ResponseEntity<Long> setAge(Long age, String username) {
        User finduser = userCheck(username);
        finduser.updateAge(age);
        return new ResponseEntity<>(age, HttpStatus.OK);
    }

    public ResponseEntity<String> setGender(String gender, String username){
        User findUser = userCheck(username);
        findUser.updateGender(gender);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<UserResponseDto> userInfo(String username) {
        User findUser = userCheck(username);
        return new ResponseEntity<>(new UserResponseDto(findUser), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<TotalSumResponseDto>> getStatus(String username) {
        User findUser = userCheck(username);
        List<TotalSumResponseDto> mypageStatus = ledgerHistoryRepository.getMypageStatus(findUser.getId());
        return new ResponseEntity<>(mypageStatus, HttpStatus.OK);

    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<MonthSumResponseDto>> getRecentStatus(String username) {
        User findUser = userCheck(username);
        List<MonthSumResponseDto> recentStatus = ledgerHistoryRepository.getRecentStatus(findUser.getId());

        return new ResponseEntity<>(recentStatus, HttpStatus.OK);
    }

    public User userCheck(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저 입니다.")
        );
    }

    @Transactional(readOnly = true)
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}

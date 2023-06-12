package com.example.apoorpoor_backend.repository.ledgerhistory;

import com.example.apoorpoor_backend.dto.account.AccountSearchCondition;
import com.example.apoorpoor_backend.dto.account.AccountTotalResponseDto;
import com.example.apoorpoor_backend.dto.account.MonthSumResponseDto;
import com.example.apoorpoor_backend.dto.account.TotalSumResponseDto;
import com.example.apoorpoor_backend.dto.ledgerhistory.LedgerHistoryListResponseDto;
import com.example.apoorpoor_backend.dto.ledgerhistory.LedgerHistoryResponseDto;
import com.example.apoorpoor_backend.dto.ledgerhistory.LedgerHistorySearchCondition;
import com.example.apoorpoor_backend.dto.user.MyPageSearchCondition;
import com.example.apoorpoor_backend.model.enumType.ExpenditureType;

import java.time.LocalDate;
import java.util.List;
public interface LedgerHistoryRepositoryCustom {

    List<LedgerHistoryListResponseDto> search(LedgerHistorySearchCondition condition);

    List<TotalSumResponseDto> getMypageStatus(Long userId);
    List<MonthSumResponseDto> getRecentStatus(Long userId);

    List<AccountTotalResponseDto> getTotalStatus(Long accountId, AccountSearchCondition condition);

    List<LedgerHistoryResponseDto> getStatus(Long accountId, AccountSearchCondition condition);

    List<MonthSumResponseDto> getStatistic(Long accountId, AccountSearchCondition condition);

    MonthSumResponseDto getDifference(Long accountId, AccountSearchCondition condition, LocalDate targetDate, int quarter);

    boolean checkEXPType2(ExpenditureType expenditureType, Long userId);

    boolean checkEXPType3(ExpenditureType expenditureType, Long userId);

    boolean checkEXPType4(ExpenditureType expenditureType, Long userId);

    boolean checkEXPType5(ExpenditureType expenditureType, Long userId);

    boolean checkEXPType7(ExpenditureType expenditureType, Long userId);

    boolean checkEXPType8(ExpenditureType expenditureType, Long userId);

    boolean checkEXPType9(ExpenditureType expenditureType, Long userId);

    boolean checkEXPType10(ExpenditureType expenditureType, Long userId);

    boolean checkEXPType11(ExpenditureType expenditureType, Long userId);

    boolean checkEXPType12(ExpenditureType expenditureType, Long userId);
}

package com.sparta.hanghaememo.service;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
//import org.springframework.transaction.annotation.Transactional;
// 이걸 임포트하면 된다고 하는데 안됨...아마.... javax와 충돌이 나는거같다.... 근데 작동해...신기...
// 다른분들은 임포트자체를 바꿔서 진행했다고 하는데 .,,,,,,핵심은 findAllByOrderByModifiedAtDesc(); 이부분이라고한다....
// 임포트 바꾸면 기존에 javax 임포트 쓰던애들은 문제 없는건가,,,, readOnly 안써도 작동하는데 ..... 이렇게 쓰면 무슨 문제가 생길까?
// 얻어걸려서 된건가,,,,,,,>????? 귀찮아 임포트 바꿔서 확인해봐야하는데.....


@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional/*(readOnly=true)> 수정가능기능임!!  되지 않음,,,,,, ^^*** 안해도 오름차순으로 포스팅됨.... !!*/
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디 없다 !! ")
        );
        memo.update(requestDto);
        return memo.getId();
    }

    @Transactional  /*문득 이아이는 왜 다 달아주어야 하는 걸까... 마치 오버라이드같은 건가...*/
    public Long deleteMemo(Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}

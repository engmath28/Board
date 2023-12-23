package com.su.board.service;

import com.su.board.dto.BoardDTO;
import com.su.board.entity.BoardEntity;
import com.su.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// DTO -> Entity 변환
// Entity -> DTO 변환

@Service
@RequiredArgsConstructor // 새로운 필드를 추가할 때 다시 생성자를 만들어서 관리해야하는 번거로움을 없애준다. (@Autowired를 사용하지 않고 의존성 주입)
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }
}

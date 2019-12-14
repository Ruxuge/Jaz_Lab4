package jaz.ADC;

import jaz.entity.SectionEntity;
import jaz.request.SectionRequest;

import java.util.List;
import java.util.Optional;

public interface SectionADC {
    List<SectionEntity> getSectionList();
    SectionRequest getSection();
    Optional<SectionEntity> getSectionById(Long sectionId);
    void save(SectionEntity sectionEntity);
    void delete(SectionEntity sectionEntity);
}

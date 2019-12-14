package jaz.controller;

import jaz.ADC.SectionADC;
import jaz.ParamRetriever;
import jaz.ADC.SectionADC;
import jaz.entity.SectionEntity;
import jaz.request.SectionRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class SectionController
{

    private SectionRequest sectionRequest;

    @Inject
    SectionADC sectionADC;

    @Inject
    ParamRetriever paramRetriever;

    public List<SectionEntity> getSectionList()
    {
        return sectionADC.getSectionList();
    }

    public SectionRequest getSectionRequest()
    {
        if (sectionRequest == null)
        {
            sectionRequest = createSectionRequest();
        }
        return sectionRequest;
    }

    private SectionRequest createSectionRequest()
    {
        if (paramRetriever.contains("sectionId"))
        {
            var sectionId = paramRetriever.getLong("sectionId");
            var section = sectionADC.getSectionById(sectionId).orElseThrow();
            return new SectionRequest(section);
        }
        return new SectionRequest();
    }

    public String save()
    {
        var section = new SectionEntity(sectionRequest.getId(),sectionRequest.getName());
        sectionADC.save(section);

        return "true";
    }
}

package com.tucker.gmall.manageservice.service.imp;

import com.tucker.gmall.bean.PmsBaseAttrInfo;
import com.tucker.gmall.bean.PmsBaseAttrValue;
import com.tucker.gmall.manageservice.mapper.AttrInfoMapper;
import com.tucker.gmall.manageservice.mapper.AttrValueMapper;
import com.tucker.gmall.service.AttrInfoService;
import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "${manage.service.version}")
public class AttrInfoImp implements AttrInfoService {


    Logger logger = LoggerFactory.getLogger(AttrInfoService.class);

    @Autowired
    AttrInfoMapper attrInfoMapper;

    @Autowired
    AttrValueMapper attrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> getAttrInfoByC3Id(String catalog3Id) {

        PmsBaseAttrInfo attrInfo = new PmsBaseAttrInfo();
        attrInfo.setCatalog3Id(catalog3Id);

        List<PmsBaseAttrInfo> attrInfos = attrInfoMapper.select(attrInfo);

        logger.info(String.valueOf(attrInfos));

        return attrInfos;
    }

    @Override
    public void insertAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrInfo.getAttrValueList();

        if(StringUtils.isBlank(pmsBaseAttrInfo.getId())){

            attrInfoMapper.insertSelective(pmsBaseAttrInfo);

            for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrValues){
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                attrValueMapper.insertSelective(pmsBaseAttrValue);
            }

        }

        Example example = new Example(PmsBaseAttrInfo.class);
        example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
        attrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);

        PmsBaseAttrValue pmsBaseAttrValueDel = new PmsBaseAttrValue();
        pmsBaseAttrValueDel.setAttrId(pmsBaseAttrInfo.getId());
        attrValueMapper.delete(pmsBaseAttrValueDel);

        for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrValues) {

                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                attrValueMapper.insertSelective(pmsBaseAttrValue);

        }
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueById(String attrId) {

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);

        return attrValueMapper.select(pmsBaseAttrValue);
    }
}

package com.example.hibernateejercicio5;

import com.example.hibernateejercicio5.model.Tag;
import com.example.hibernateejercicio5.model.TagColor;
import com.example.hibernateejercicio5.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    @DisplayName("Añadir una enumeración a una etiqueta")
    public void checkTagColor() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Tag tagEnum = new Tag (239L, "Proyecto PK", "Blue");
        Tag tagEnum2 = new Tag(239L, "Proyecto PL", "Green");
        Tag tagEnum3 = new Tag(455L,"Proyecto OC", "Yellow");

        tagEnum.setTagType(TagColor.BLUE);
        tagEnum2.setTagType(TagColor.GREEN);
        tagEnum3.setTagType(TagColor.YELLOW);

        session.save(tagEnum);
        session.save(tagEnum2);
        session.save(tagEnum3);

        session.beginTransaction();

        session.getTransaction().commit();
    }
}

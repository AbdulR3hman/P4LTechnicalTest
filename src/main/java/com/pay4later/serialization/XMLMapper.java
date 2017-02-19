package com.pay4later.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pay4later.model.User;

import javax.xml.stream.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 18:46
 * Class:       com.pay4later.serialization.XMLMapper
 */
public class XMLMapper implements UserMapper<User> {

    private XmlMapper personMapper;
    private XMLInputFactory xmlInputFactory;
    private XMLOutputFactory xmlOutputFactory;

    public XMLMapper() {
        personMapper = new XmlMapper();
        personMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        //We will be using the xml write factory and stream
        //Jackson's XML extension is causing an issue -- due to a bug.
        //So we will be asking the Java XMLStreamWriter to write to the file
        xmlInputFactory = XMLInputFactory.newFactory();
        xmlOutputFactory = XMLOutputFactory.newFactory();
        personMapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);

    }

    /**
     * Write list of people to to @param destination.
     * We are using Java's xml stream writer due to a bug in the Jackson library
     *
     * @param people
     */
    public void serialisePersons(File destination, List<User> people) {

        // First create Stax components we need
        XMLStreamWriter sw;

        try {
            sw = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(destination), "utf-8");
            XmlMapper mapper = new XmlMapper(xmlInputFactory);

            sw.writeStartDocument();
            sw.writeStartElement("users");

            for (User p : people)
                mapper.writeValue(sw, p);

            sw.writeEndElement();
            sw.writeEndDocument();


        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (XMLStreamException xmle) {
            xmle.printStackTrace();
        }
    }

    /**
     * get a list of users from the @param source -- This is an XMl file.
     *
     * @return list of users
     */
    public List<User> deserializePersons(File source) {
        List<User> people = new LinkedList<>();

        try {
            people = personMapper.readValue(source, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return people;
    }
}

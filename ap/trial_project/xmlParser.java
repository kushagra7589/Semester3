package snippet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class ParseXML {
	
	
	public static void main(String[] args)
	{
		boolean bAuthor = false;
		boolean bTitle = false;
		boolean bPages = false;
		boolean bYear = false;
		boolean bVolume =  false;
		boolean bJournal = false;
//		boolean bUrl = false;
		int count = 0;
		try
		{
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader reader = factory.createXMLEventReader(new FileReader("dblp.xml"));
			while(reader.hasNext())
			{
				XMLEvent event = reader.nextEvent();
				switch(event.getEventType())
				{
				case	XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();
					if(qName.equalsIgnoreCase("article")					) {
//						System.out.println("Article found!");
						count += 1;
						if(count % 1000 == 0)
							System.out.println(count);
						Iterator<Attribute> attri = startElement.getAttributes();
						while(attri.hasNext())
						{
							String atr = attri.next().getValue();
//							System.out.println("Attribute : " + atr);
						}
					}
					else if(qName.equalsIgnoreCase("author")) bAuthor = true;
					else if(qName.equalsIgnoreCase("title")) bTitle = true;
					else if(qName.equalsIgnoreCase("pages")) bPages = true;
					else if(qName.equalsIgnoreCase("year")) bYear = true;
					else if(qName.equalsIgnoreCase("volume")) bVolume = true;
					else if(qName.equalsIgnoreCase("journal")) bJournal = true;
					else if(qName.equalsIgnoreCase("url")) bUrl = true;
					
					break;
					
				case XMLStreamConstants.CHARACTERS :
					Characters characters = event.asCharacters();
					if(bAuthor) {
//						System.out.println("Author: " + characters.getData());
						bAuthor = false;
					}
					if(bTitle) {
//						System.out.println("Title: " + characters.getData());
						bTitle = false;
					}
					if(bYear) {
//						System.out.println("Year: " + characters.getData());
						bYear = false;
					}
					if(bJournal) {
//						System.out.println("Journal: " + characters.getData());
						bJournal = false;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement = event.asEndElement();
					if(endElement.getName().getLocalPart().equalsIgnoreCase("article"))
					{
//						System.out.println("Article khatam ho gaya !");
					}
				}
				
			}
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		catch (XMLStreamException e)
		{
			System.out.println(count);
			e.printStackTrace();
		}
	}
}

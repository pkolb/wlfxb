package eu.clarin.weblicht.wlfxb.tc.xb;

import eu.clarin.weblicht.wlfxb.tc.api.MatchedCorpus;
import eu.clarin.weblicht.wlfxb.utils.CommonAttributes;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 * @author Yana Panchenko
 *
 */
@XmlRootElement(name = MatchedCorpusStored.XML_NAME)
@XmlAccessorType(XmlAccessType.NONE)
public class MatchedCorpusStored implements MatchedCorpus {

    public static final String XML_NAME = "corpus";
    @XmlAttribute(name = CommonAttributes.NAME, required = true)
    private String name;
    @XmlAttribute(name = CommonAttributes.PID, required = true)
    protected String pid;
    @XmlElement(name = MatchedItemStored.XML_NAME)
    protected List<MatchedItemStored> matchedItems = new ArrayList<MatchedItemStored>();

    MatchedCorpusStored() {
    }

    MatchedCorpusStored(String name, String pid) {
        this.name = name;
        this.pid = pid;
    }

    @Override
    public MatchedItemStored[] getMatchedItems() {
        // return array in order not to let user add new things to the items list
        MatchedItemStored[] items = new MatchedItemStored[matchedItems.size()];
        return matchedItems.toArray(items);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPID() {
        return pid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(XML_NAME);
        sb.append(" ");
        sb.append(name);
        sb.append(" ");
        sb.append(pid);
        sb.append(" ");
        sb.append(matchedItems.toString());
        return sb.toString().trim();
    }
}
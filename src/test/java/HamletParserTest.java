import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.*;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();

    }
    //Change this, don't use replaceAll
    @Test
    public void testChangeHamletToLeon() {
        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        String replacementString = "Leon";
        String newText = matcher.replaceAll(replacementString);
        Matcher newMatcher = pattern.matcher(newText);
        Assert.assertFalse(newMatcher.find());
        hamletParser.writeFile(newText);
    }
    //Change this, don't use replaceAll
    @Test
    public void testChangeHoratioToTariq() {
        Pattern horPattern = Pattern.compile("horatio",Pattern.CASE_INSENSITIVE);
        Matcher matcher = horPattern.matcher(hamletText);
        String replacementString = "Tariq";
        String newText = matcher.replaceAll(replacementString);
        Matcher newMatcher = horPattern.matcher(newText);
        Assert.assertFalse(newMatcher.find());
        hamletParser.writeFile(newText);
    }

    @Test
    public void testFindHoratio() {
        Pattern pattern = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        Assert.assertTrue(matcher.find());

    }

    @Test
    public void testFindHamlet() {
        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
      Assert.assertTrue(matcher.find());
    }
}
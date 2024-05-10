package sacovec.olga.page;

import com.codeborne.selenide.Selenide;
import sacovec.olga.components.ContentBlock;
import sacovec.olga.components.LeftMenuClass;

public class DocumentationPage {
    public LeftMenuClass getLeftMenuClass(){
        return Selenide.page(LeftMenuClass.class);
    }
    public ContentBlock getContentBlock(){
        return Selenide.page(ContentBlock.class);
    }
}

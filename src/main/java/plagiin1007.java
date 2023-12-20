import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.ide.BrowserUtil;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class plagiin1007 extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent event) {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);
        if (editor != null) {
            String selectedText = editor.getSelectionModel().getSelectedText();
            if (selectedText != null && !selectedText.isEmpty()) {
                String encodedText = URLEncoder.encode(selectedText, StandardCharsets.UTF_8);
                String url = "https://www.google.com/search?q=" + encodedText;
                BrowserUtil.browse(url);
            }
        }
    }
}

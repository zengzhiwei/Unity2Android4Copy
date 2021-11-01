package com.example.moduleb;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Looper;
import android.util.Log;

public class MainActivity extends UnityPlayerActivity {
    /*
     * 向剪贴板中添加文本
     */
    public static void copyTextToClipboard(final String str) {
        Log.i("speedmobile", "copyTextToClipboard begin ==== " );
        Activity activity = UnityPlayer.currentActivity;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ClipboardManager clipboard = (ClipboardManager) activity.getSystemService(Activity.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("data", str);
                clipboard.setPrimaryClip(clipData);

                Log.i("speedmobile", "DoCopyText text: " + str);
            }
        });
    }

    /*
     * 从剪贴板中获取文本
     */
    public static String getTextFromClipboard() {
        Log.i("speedmobile", "getTextFromClipboard begin ==== " );
        Activity activity = UnityPlayer.currentActivity;
        ClipboardManager clipboard = (ClipboardManager)activity.getSystemService(Activity.CLIPBOARD_SERVICE);

        if (clipboard != null && clipboard.hasPrimaryClip()
                && clipboard.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
            ClipData cdText = clipboard.getPrimaryClip();
            ClipData.Item item = cdText.getItemAt(0);
            return item.getText().toString();
        }
        return "null";
    }


}
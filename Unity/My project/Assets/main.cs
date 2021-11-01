using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class main : MonoBehaviour
{
    // Start is called before the first frame update
    
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void onClickCopy()
    {
        Debug.LogWarning("unity copy");
        
        using (AndroidJavaClass androidClass = new AndroidJavaClass("com.example.androidtools.MainActivity"))
        {
            androidClass.CallStatic("copyTextToClipboard", "test text");
        }
    }
    
    public void onClickPaste()
    {
        Debug.Log("unity paste ");
        
        using (AndroidJavaClass androidClass = new AndroidJavaClass("com.example.androidtools.MainActivity"))
        {
            string s = androidClass.CallStatic<string>("getTextFromClipboard");
            Debug.LogWarning("unity paste s=" + s);
        }
    }
}

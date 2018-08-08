package com.jcohy.study.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class ExecuteShellCommand extends Thread {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String command;
    private String ofilename;

    public ExecuteShellCommand(String command, String ofilename) {
        this.command = command;
        this.ofilename = ofilename;
    }

    /*
    public static String executeCommand(String command) {
        StringBuffer output = new StringBuffer();
        BufferedReader reader = null;

        Process p;

        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return output.toString();
    }
    */

    public void run() {
        Process p;
        BufferedReader reader = null;
        OutputStreamWriter writer = null;

        try {
            p = Runtime.getRuntime().exec(command);
            //p.waitFor();
            File file = new File(ofilename);
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            writer = new OutputStreamWriter(new FileOutputStream(file));
            String line = "";
            while ((line = reader.readLine()) != null) {
                writer.append(line).append("\n");
                writer.flush();
            }
        } catch (Exception e) {
            logger.error("execute shell error: ", e);
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                logger.error("close stream error: ", e);
            }
        }
    }
}
package com.github.kulya.gradle.plugins.jmeter

import com.github.kulya.gradle.plugins.jmeter.helper.FileUtils;

public class JmeterCleanReportTask extends JmeterAbstractTask {

    /**
     * Directory in which the reports are stored.
     * <p/>
     * By default build/jmeter-report"
     */
    private File reportDir;

    @Override
    protected void runTaskAction() throws IOException {
        boolean result = cleanReportDir();
        if (!result){
            throw new IOException("Unable to clean report.");
        }
    }

    @Override
    protected void loadPropertiesFromConvention() {
        super.loadPropertiesFromConvention();
        reportDir = getReportDir();
    }

    private boolean cleanReportDir() {
        return FileUtils.delete(getReportDir(),  new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.lastIndexOf('.jpg')>0 || name.lastIndexOf('.xsl')>0)
                {
                   return false;
                }
                return true;
            }
        });
    }

    File getReportDir() {
        return reportDir
    }

    void setReportDir(File reportDir) {
        this.reportDir = reportDir
    }
}

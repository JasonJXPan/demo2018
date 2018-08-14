package com.pjx.demo2018.dailytest.domain;

/**
 * Created by juqi on 18/8/14.
 */
public class TreeSetObj implements Comparable<TreeSetObj> {
    private int sequence;
    private String content;

    @Override
    public int compareTo(TreeSetObj o) {
        return this.getSequence()-o.getSequence();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TreeSetObj that = (TreeSetObj) o;

        if (sequence != that.sequence) {
            return false;
        }
        return content != null ? content.equals(that.content) : that.content == null;
    }

    @Override
    public int hashCode() {
        int result = sequence;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TreeSetObj{" +
                "sequence=" + sequence +
                ", content='" + content + '\'' +
                '}';
    }
}

package org.james.habbo.avatars.details;

public class AvatarDetails
{
    private String mUserName;
    private String mFigure;
    private char mSex;
    private String mMission;
    private int mTickets;
    private int mFilm;
    private String mPoolFigure;

    public AvatarDetails()
    {

    }

    public String UserName()
    {
        return mUserName;
    }

    public String Figure()
    {
        return mFigure;
    }

    public char Sex()
    {
        return mSex;
    }

    public String Mission()
    {
        return mMission;
    }

    public int Tickets()
    {
        return mTickets;
    }

    public int Film()
    {
        return mFilm;
    }

    public String PoolFigure()
    {
        return mPoolFigure;
    }

    public void setUserName(String userName)
    {
        mUserName = userName;
    }

    public void setFigure(String figure)
    {
        mFigure = figure;
    }

    public void setSex(char sex)
    {
        mSex = sex;
    }

    public void setMission(String mission)
    {
        mMission = mission;
    }

    public void setTickets(int tickets)
    {
        mTickets = tickets;
    }

    public void setFilm(int film)
    {
        mFilm = film;
    }

    public void setPoolFigure(String poolFigure)
    {
        mPoolFigure = poolFigure;
    }

    //Add toProtocol method

}

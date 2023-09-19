class main {

    public static void main(String[] args)
    {
        int threads = Integer.parseInt(args[0]);
        SyncedObject object = new SyncedObject();

        RED[] reds = new RED[threads];
        BLUE[] blues = new BLUE[threads];
        for(int i = 0; i < threads; i++)
        {
            reds[i] = new RED(object);
            blues[i] = new BLUE(object);

            Thread r = new Thread(reds[i]);
            Thread b = new Thread(blues[i]);
            r.start();
            b.start();
        }
    }
}

class SyncedObject
{
    public int color = -1;
    public boolean noMoreThreads = false;
    public int numThreads = 0;
    
    public void grantAccess(int redOrBlue)
    {
        if(numThreads == 0)
        {
            color = redOrBlue;
        }

        if(color == redOrBlue && !noMoreThreads)
        {
            if(redOrBlue == 0)
            {
                if(numThreads == 0)
                {
                    color = 0;
                }
                System.out.println("Red Thread has entered");
                numThreads++;
            }
            else if(redOrBlue == 1)
            {
                if(numThreads == 0)
                {
                    color = 1;
                }
                System.out.println("Blue Thread has entered");
                numThreads++;
            }
        }
        else
        {
            noMoreThreads = true;
        }
    }

    public void exit(int redOrBlue)
    {
        if(redOrBlue == color && numThreads > 0)
        {
            numThreads--;
            if(redOrBlue == 0)
            {
                System.out.println("Red Thread has exited");
            }
            else
            {
                System.out.println("Blue Thread has exited");
            }
        }
    }
}

class RED implements Runnable{
    private SyncedObject object;

    public RED(SyncedObject obj)
    {
        this.object = obj;
    }
    @Override
    public void run() {
        int i = 10;
        try {
            synchronized(object)
            {
                while(i > 0)
                {
                    object.grantAccess(0);
                    Thread.sleep(500);
                    object.exit(0);
                    i--;
                }
            }
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
            return;
        } 
    }
    
}

class BLUE implements Runnable{
    private SyncedObject object;

    public BLUE(SyncedObject obj)
    {
        this.object = obj;
    }
     @Override
    public void run() {
        int i = 10;

        try{
            synchronized(object)
            {
                while(i > 0)
                {
                    object.grantAccess(1);
                    Thread.sleep(500);
                    object.exit(1);
                    i--;
                }
            }
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
            return;
        }
    }
}

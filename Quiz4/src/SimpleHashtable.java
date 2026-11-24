public class SimpleHashtable
{
    private StoredPlayer[] hashtable;

    public SimpleHashtable()
    {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key)
    {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value)
    {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey))
        {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length)
            {
                hashedKey = (hashedKey + 1) % hashtable.length;

                while (isOccupied(hashedKey) && hashedKey != stoppingIndex)
                {
                    hashedKey = (hashedKey + 1) % hashtable.length;
                }
            }
            else
            {
                hashedKey++;
            }
        }

        if (isOccupied(hashedKey))
        {
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        }
        else
        {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public Player get(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            return null;
        }
        return hashtable[hashedKey].value;
    }

    public Player remove(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            return null;
        }

        Player removedPlayer = hashtable[hashedKey].value;
        hashtable[hashedKey] = null;
        StoredPlayer[] oldHashtable = hashtable;
        hashtable = new StoredPlayer[oldHashtable.length];

        for (int i = 0; i < oldHashtable.length; i++)
        {
            if (oldHashtable[i] != null)
            {
                put(oldHashtable[i].key, oldHashtable[i].value);
            }
        }
        return removedPlayer;
    }

    private int findKey(String key)
    {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] == null && hashtable[hashedKey].key.equals(key))
        {
            return hashedKey;
        }

        int stoppingIndex = hashedKey;
        hashedKey = (hashedKey + 1) % hashtable.length;

        while (hashedKey != stoppingIndex && hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
        {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
        {
            return hashedKey;
        }
        return -1;
    }

    private boolean isOccupied(int index)
    {
        return hashtable[index] != null;
    }

    public void printHashtable()
    {
        for (int i = 0; i < hashtable.length; i++)
        {
            if (hashtable[i] != null) {
                System.out.println("Element " + i + " " + hashtable[i].value);
            }
            else
            {
                System.out.println("Element " + i + " null");
            }
        }
    }
}
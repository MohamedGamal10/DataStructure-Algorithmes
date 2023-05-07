public class KeyValuePair<Tkey,Tvalue>
{
    Tkey _key;
    Tvalue _value;

    public Tkey get_key() {
        return _key;
    }

    public Tvalue get_value() {
        return _value;
    }

    public void set_value(Tvalue _value) {
        this._value = _value;
    }

    public KeyValuePair(Tkey key, Tvalue val)
    {
        _key = key;
        _value =val;

    }
}

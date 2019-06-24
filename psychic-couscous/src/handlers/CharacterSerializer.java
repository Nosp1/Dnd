package handlers;

import com.google.gson.*;

import java.lang.reflect.Type;

public class CharacterSerializer implements JsonSerializer<Character> {

    @Override
    public JsonElement serialize(Character character, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonCharacter = new JsonObject();

        jsonCharacter.addProperty("name", character.getName());
        jsonCharacter.addProperty("age", character.getAge());
        jsonCharacter.addProperty("gender", character.getGender());

        JsonArray race = new JsonArray();

        race.add(character.getRace().getName());
        race.add(character.getRace().getMaxAge());
        race.add(character.getRace().getLanguages());
        jsonCharacter.addProperty("race", race.toString());

        return jsonCharacter;
    }
}

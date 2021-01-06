package ru.udisondev.eventservice.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.convert.converter.Converter;
import ru.udisondev.eventservice.service.command.CreateCommand;
import ru.udisondev.eventservice.web.dto.CreateRequest;

import java.util.UUID;

import static org.mockito.Mockito.when;

class CreateRequestToCreateCommandTest {
    private final Converter<CreateRequest, CreateCommand> converter = new CreateRequestToCreateCommand();
    private CreateRequest request;

    @BeforeEach
    void init() {
        request = Mockito.mock(CreateRequest.class);
        when(request.getId()).thenReturn(UUID.randomUUID());
        when(request.getCity()).thenReturn("City");
        when(request.getCustomerId()).thenReturn(UUID.randomUUID());
        when(request.getTypeId()).thenReturn(UUID.randomUUID());
        when(request.getDescription()).thenReturn("I try to make a normal description. I hope that is OK!");
        when(request.getTitle()).thenReturn("Title");
    }

    @Test
    void givenNullArg_whenConvert_thenThrowIllegalStateException() {
        Assertions.assertThatThrownBy(() -> converter.convert(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenNullTitle_whenConvert_thenThrowIllegalStateException() {
        when(request.getTitle()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be null");
    }

    @Test
    void givenNullDescription_whenConvert_thenThrowIllegalStateException() {
        when(request.getDescription()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be null");
    }

    @Test
    void givenNullId_whenConvert_thenThrowIllegalStateException() {
        when(request.getId()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be null");
    }

    @Test
    void givenNullCity_whenConvert_thenThrowIllegalStateException() {
        when(request.getCity()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be null");
    }

    @Test
    void givenNullCustomerId_whenConvert_thenThrowIllegalStateException() {
        when(request.getCustomerId()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be null");
    }

    @Test
    void givenNullTypeId_whenConvert_thenThrowIllegalStateException() {
        when(request.getTypeId()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be null");
    }

    @Test
    void givenTitleLengthLessThan2_whenConvert_thenThrowIllegalStateException() {
        when(request.getTitle()).thenReturn("t");
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("greater than 2");
    }

    @Test
    void givenTitleLengthGreaterThan64_whenConvert_thenThrowIllegalStateException() {
        when(request.getTitle()).thenReturn(getLongString());
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("less than 64");
    }

    @Test
    void givenDescriptionLengthLessThan20_whenConvert_thenThrowIllegalStateException() {
        when(request.getDescription()).thenReturn("Simple");
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("greater than 20");
    }

    @Test
    void givenDescriptionLengthGreaterThan10000_whenConvert_thenThrowIllegalStateException() {
        when(request.getDescription()).thenReturn(getLongString());
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("less than 10000");
    }

    @Test
    void givenCityIsBlank_whenConvert_thenThrowIllegalStateException() {
        when(request.getCity()).thenReturn("   ");
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be blank");
    }

    @Test
    void givenCityLengthLessThan2_whenConvert_thenThrowIllegalStateException() {
        when(request.getDescription()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be null");
    }

    @Test
    void givenCityLengthGreaterThan64_whenConvert_thenThrowIllegalStateException() {
        when(request.getCity()).thenReturn(getLongString());
        Assertions.assertThatThrownBy(() -> converter.convert(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("less than 64");
    }

    private String getLongString() {
        return "So, Recode reported today that Twitter was tinkering around with the idea of expanding its 140 character" +
                " limit to a number a bit higher….10,000 characters.\n" +
                "\n" +
                "But what, you ask (and I’m glad you did), does 10,000 characters look like? Well, hey. Let’s find out.\n" +
                "\n" +
                "Soooo, did you see the Warriors game last night? Crazy, right? It was nice to see Harrison Barnes back and " +
                "the entire crowd cheered when he entered the game. Steph Curry is probably not human, because he shoots the ball " +
                "from the parking lot and it swishes like butter. How many characters am I up to now? Lemme check, so hold on….\n" +
                "\n" +
                "597.\n" +
                "\n" +
                "Anyways, then it started raining today and my dogs don’t like rain so it’s really difficult to take them " +
                "outside to do their business in the morning when they don’t want to deal with the rain. I try to talk " +
                "them into the fact that they’re actually getting a bath and pooping at the same time, kind of a two" +
                " birds with one stone thing. They don’t buy it. Speaking of rain, it didn’t rain on my wedding day " +
                "like the weather people thought it would. How do they keep their jobs when they’re wrong all of the " +
                "time? It’s almost like they could do my job. Wait, I didn’t mean that how it sounded. Where are we " +
                "at now?\n" +
                "\n" +
                "1194.\n" +
                "\n" +
                "OK. So anyways. Here’s a favorite quote of mine from Bill Clinton:\n" +
                "\n" +
                "If you live long enough, you’ll make mistakes. But if you learn from them, you’ll be a better person. " +
                "It’s how you handle adversity, not how it affects you. The main thing is never quit, never quit, never" +
                " quit.\n" +
                "\n" +
                "I think what he’s saying is that you can make mistakes, but you have to learn from them. I’ve made a" +
                " bunch of mistakes, how about you? My dogs made a mistake this morning because they didn’t want to go " +
                "out in the rain. But that’s cool, I don’t get mad. Life’s too short, you know?\n" +
                "\n" +
                "Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never " +
                "quit. " +
                "Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never " +
                "quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. " +
                "Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never " +
                "quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. " +
                "Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never " +
                "quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit.\n" +
                "\n" +
                "2507.\n" +
                "\n" +
                "Did you see the President speak about gun control today? It’s important. Probably the most important" +
                " problem of our time and we have to solve it. Here’s what he said today:\n" +
                "\n" +
                "THE PRESIDENT: Happy New Year, everybody. Before the New Year, I mentioned that I had given the charge " +
                "to my " +
                "Attorney General, FBI Director, Deputy Director at the ATF, and personnel at my White House to work " +
                "together to see what more we could do to prevent a scourge of gun violence in this country.\n" +
                "\n" +
                "I think everybody here is all too familiar with the statistics. We have tens of thousands of people" +
                " every single year who are killed by guns. We have suicides that are committed by firearms at a rate " +
                "that far exceeds other countries. We have a frequency of mass shootings that far exceeds other countries " +
                "in frequency.\n" +
                "\n" +
                "And although it is my strong belief that for us to get our complete arm around the problem Congress" +
                " needs to act, what I asked my team to do is to see what more we could do to strengthen our enforcement " +
                "and prevent guns from falling into the wrong hands to make sure that criminals, people who are mentally " +
                "unstable, those who could pose a danger to themselves or others are less likely to get them.\n" +
                "\n" +
                "And I’ve just received back a report from Attorney General Lynch, Director Comey, as well as Deputy " +
                "Director Brandon about some of the ideas and initiatives that they think can make a difference. " +
                "And the good news is, is that these are not only recommendations that are well within my legal authority " +
                "and the executive branch, but they’re also ones that the overwhelming majority of the American people, " +
                "including gun owners, support and believe.\n" +
                "\n" +
                "So over the next several days, we’ll be rolling out these initiatives. We’ll be making sure that people " +
                "have a very clear understanding of what can make a difference and what we can do. And although we have " +
                "to be very clear that this is not going to solve every violent crime in this country, it’s not going " +
                "to prevent every mass shooting, it’s not going to keep every gun out of the hands of a criminal, " +
                "it will potentially save lives and spare families the pain and the extraordinary loss that they’ve" +
                " suffered as a consequence of a firearm getting in the hands of the wrong people.\n" +
                "\n" +
                "I’m also confident that the recommendations that are being made by my team here are ones that are " +
                "entirely consistent with the Second Amendment and people’s lawful right to bear arms. And we’ve been " +
                "very careful recognizing that, although we have a strong tradition of gun ownership in this country," +
                " that even though it’s who possess firearms for hunting, for self-protection, and for other legitimate" +
                " reasons, I want to make sure that the wrong people don’t have them for the wrong reasons.\n" +
                "\n" +
                "So I want to say how much I appreciate the outstanding work that the team has done. Many of you worked " +
                "over the holidays to get this set of recommendations to me. And I’m looking forward to speaking to the " +
                "American people over the next several days in more detail about it.\n" +
                "\n" +
                "Thank you very much, everybody.\n" +
                "\n" +
                "Regardless of where you stand on the matter, we have to change some things.\n" +
                "\n" +
                "Back to tech. Are you at CES? I’m not this year. Mostly because there’s a lot of germs and I shouldn’t " +
                "be around them if I can help it. I’m pretty sure my dogs would have liked it though, because there’s a " +
                "lot of tech in Vegas for all kinds of people (and pets). If you were a dog would you want a phone? " +
                "Or a self-feeding thing? Of course you would. You’d have to sit around all day watching your parents " +
                "use technology while you sit around and lick yourself. What kind of existence is that? I know, right? " +
                "I hope there’s some dog tech that comes out of the conference, otherwise it’s a wash.\n" +
                "\n" +
                "6294.\n" +
                "\n" +
                "Time for another quote. JFK this time:\n" +
                "\n" +
                "When written in Chinese, the word ‘crisis’ is composed of two characters. One represents danger and the" +
                " other represents opportunity.\n" +
                "\n" +
                "I think what JFK meant was just because things aren’t going your way doesn’t mean that it won’t " +
                "eventually. You have to play the long game, you have to stick in there and see things as far as you can" +
                " possibly see them. It’s like Twitter . People are worried about whether Twitter can weather the storm " +
                "of lack of growth. I think it can. What about the character count? Well, I personally feel like asking " +
                "people to keep their thoughts shorter make them more powerful. They’re easier to share. Repeat, etc. " +
                "What will happen when people can put this much text in a tweet? I don’t know. I do know that I don’t " +
                "want to spend hours reading tweets because I like the fact that I can glance at the app and figure out " +
                "what’s going on pretty quickly.\n" +
                "\n" +
                "If I wanted to write a book, I’d do it on Facebook.\n" +
                "\n" +
                "But maybe people want more characters. I’m not sure who, though. I’d like to meet them. Maybe they have" +
                " dogs, too. We could chat about that.\n" +
                "\n" +
                "What are your favorite movies? I have a top 10 and it changes sometimes:\n" +
                "\n" +
                "– Rocky\n" +
                "– Forrest Gump\n" +
                "– Cast Away\n" +
                "– Fantastic Mr. Fox\n" +
                "– Signs\n" +
                "– Lars and the Real Girl\n" +
                "– Superbad\n" +
                "– Spaceballs\n" +
                "– Shawshank Redemption\n" +
                "– Jackie Brown\n" +
                "\n" +
                "Share yours in the comments if you want.\n" +
                "\n" +
                "7657.\n" +
                "\n" +
                "Here’s another quote, this time from Maya Angelou:\n" +
                "\n" +
                "The thing to do, it seems to me, is to prepare yourself so you can be a rainbow in somebody else’s " +
                "cloud. Somebody who may not look like you. May not call God the same name you call God – if they call " +
                "God at all. I may not dance your dances or speak your language. But be a blessing to somebody. That’s " +
                "what I think.\n" +
                "\n" +
                "Being a blessing to someone is a great way to be. Have you been a blessing to someone lately? I feel " +
                "like we could all do a better job of that, even if it’s in small ways. I feel like people always want " +
                "to do something great and massively huge, but forget about all of the little things along the way." +
                " Making someone smile, holding the door for someone, giving someone a hug when they really really need" +
                " it. Those kinds of things last forever. Don’t hold back on doing a bunch of little great things to do" +
                " something huge that you’ll get overwhelmed with and not follow through on.\n" +
                "\n" +
                "8614. Wow, this is a lot of characters.\n" +
                "\n" +
                "I feel like Kurt Wagner did a good job of talking about the ramifications of expanding tweets to 10,000" +
                " characters:\n" +
                "\n" +
                "The design aspect is key. Making Tweets bigger by adding more content or bigger pictures has diminished" +
                " user engagement in the past, according to one source. That makes sense. If tweets take a long time to " +
                "consume or take up more space on your screen, it’s likely that you’ll view (and engage with) fewer of " +
                "them. So Twitter is trying to add more content without disrupting the way you currently scroll through" +
                " your timeline.\n" +
                "\n" +
                "How can Twitter become more like Facebook without becoming Facebook? There’s too many words on Facebook" +
                ", something the company itself is trying to get away from by introducing all sorts of new media, " +
                "like 360 degree videos. There’s always a place for long form content, and just because you have the " +
                "space doesn’t mean you have to fill it. But still, a lot of people will try. Spammers will definitely" +
                " try. In fact, can you imagine getting spam tweets that are over 140 characters? Ugh. It’ll be like " +
                "reading SPAM in your EMAIL!@$#!@#!@#\n" +
                "\n" +
                "One more quote, this one from Clarence Darrow:\n" +
                "\n" +
                "When we fully understand the brevity of life, its fleeting joys and unavoidable pains; when we accept " +
                "the facts that all men and women are approaching an inevitable doom: the consciousness of it should" +
                " make us more kindly and considerate of each other. This feeling should make men and women use their" +
                " best efforts to help their fellow travelers on the road, to make the path brighter and easier as we " +
                "journey on. It should bring a closer kinship, a better understanding, and a deeper sympathy for the " +
                "wayfarers who must live a common life and die a common death.\n" +
                "\n" +
                "Maybe Twitter should just acquire Medium instead.\n" +
                "\n" +
                "Oops, I went over the “limit.”";
    }

}
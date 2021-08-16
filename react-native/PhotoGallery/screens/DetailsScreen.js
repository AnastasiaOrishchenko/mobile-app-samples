import React from 'react';
import {Text} from 'react-native';

function DetailsScreen({route}) {
  return <Text>Photo author: {route.params.photo.author}</Text>;
}

export default DetailsScreen;
